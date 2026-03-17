package com.example.techgicus_ebilling.techgicus_ebilling.service;


import com.example.techgicus_ebilling.techgicus_ebilling.datamodel.entity.FreightMemo;
import com.example.techgicus_ebilling.techgicus_ebilling.dto.freightmemoDto.FreightMemoRequestDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.dto.freightmemoDto.FreightMemoResponseDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.repository.FreightMemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class FreightMemoService {

    @Autowired
    private FreightMemoRepository repository;

    public FreightMemoResponseDTO create(FreightMemoRequestDTO dto) {
        FreightMemo memo = mapToEntity(dto);
        calculate(memo);
        memo = repository.save(memo);
        return mapToResponseDTO(memo);
    }

    public Page<FreightMemoResponseDTO> getAll(Pageable pageable) {

        return repository.findAll(pageable)
                .map(this::mapToResponseDTO);
    }

    public FreightMemoResponseDTO getById(Long id) {
        FreightMemo memo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Memo not found"));
        return mapToResponseDTO(memo);
    }

    public FreightMemoResponseDTO update(Long id, FreightMemoRequestDTO dto) {
        FreightMemo memo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Memo not found"));

        memo.setBillNo(dto.getBillNo());
        memo.setPartyName(dto.getPartyName());
        memo.setTransportname(dto.getTransportname());
        memo.setVehicleNo(dto.getVehicleNo());
        memo.setLoadingWeight(dto.getLoadingWeight());
        memo.setUnloadingWeight(dto.getUnloadingWeight());
        memo.setFreightRate(dto.getFreightRate());
        memo.setAdvanceCash(dto.getAdvanceCash());
        memo.setAdvanceAccount(dto.getAdvanceAccount());
        memo.setShortageAmount(dto.getShortageAmount());
        memo.setOtherdeduction(dto.getOtherdeduction());
        memo.setLoadingDate(dto.getLoadingDate());
        memo.setUnloadingDate(dto.getUnloadingDate());

        calculate(memo);

        memo = repository.save(memo);

        return mapToResponseDTO(memo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private FreightMemo mapToEntity(FreightMemoRequestDTO dto) {
        FreightMemo memo = new FreightMemo();
        memo.setBillNo(dto.getBillNo());
        memo.setPartyName(dto.getPartyName());
        memo.setTransportname(dto.getTransportname());
        memo.setVehicleNo(dto.getVehicleNo());
        memo.setLoadingWeight(dto.getLoadingWeight());
        memo.setUnloadingWeight(dto.getUnloadingWeight());
        memo.setFreightRate(dto.getFreightRate());
        memo.setAdvanceCash(dto.getAdvanceCash());
        memo.setAdvanceAccount(dto.getAdvanceAccount());
        memo.setShortageAmount(dto.getShortageAmount());
        memo.setOtherdeduction(dto.getOtherdeduction());
        memo.setLoadingDate(dto.getLoadingDate());
        memo.setUnloadingDate(dto.getUnloadingDate());
        return memo;
    }

    private FreightMemoResponseDTO mapToResponseDTO(FreightMemo memo) {
        FreightMemoResponseDTO dto = new FreightMemoResponseDTO();

        dto.setId(memo.getId());
        dto.setBillNo(memo.getBillNo());
        dto.setPartyName(memo.getPartyName());
        dto.setTransportname(memo.getTransportname());
        dto.setVehicleNo(memo.getVehicleNo());
        dto.setLoadingWeight(memo.getLoadingWeight());
        dto.setUnloadingWeight(memo.getUnloadingWeight());
        dto.setShortageWeight(memo.getShortageWeight());
        dto.setFreightRate(memo.getFreightRate());
        dto.setFreightAmount(memo.getFreightAmount());
        dto.setAdvanceCash(memo.getAdvanceCash());
        dto.setAdvanceAccount(memo.getAdvanceAccount());
        dto.setShortageAmount(memo.getShortageAmount());
        dto.setOtherdeduction(memo.getOtherdeduction());
        dto.setFinalAmount(memo.getFinalAmount());
        dto.setLoadingDate(memo.getLoadingDate());
        dto.setUnloadingDate(memo.getUnloadingDate());

        return dto;
    }

    private void calculate(FreightMemo memo) {

        double loading = memo.getLoadingWeight() != null ? memo.getLoadingWeight() : 0;
        double unloading = memo.getUnloadingWeight() != null ? memo.getUnloadingWeight() : 0;
        double rate = memo.getFreightRate() != null ? memo.getFreightRate() : 0;

        double advanceCash = memo.getAdvanceCash() != null ? memo.getAdvanceCash() : 0;
        double advanceAccount = memo.getAdvanceAccount() != null ? memo.getAdvanceAccount() : 0;
        double shortageAmount = memo.getShortageAmount() != null ? memo.getShortageAmount() : 0;
        double otherdeduction = memo.getOtherdeduction() != null ? memo.getOtherdeduction() : 0;

        double shortageWeight = loading - unloading;
        double freightAmount = unloading * rate;
        double finalAmount = freightAmount - advanceCash - advanceAccount - shortageAmount - otherdeduction;

        memo.setShortageWeight(shortageWeight);
        memo.setFreightAmount(freightAmount);
        memo.setFinalAmount(finalAmount);
    }
}