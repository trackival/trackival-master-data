package com.trackival.mdm.contact.exception;

import com.trackival.mdm.common.exception.TrackivalMasterDataException;
import com.trackival.mdm.contact.dto.AddContactInput;
import lombok.Getter;

@Getter
public class CouldNotAddContactException extends TrackivalMasterDataException {
    private final AddContactInput input;

    public CouldNotAddContactException(AddContactInput input) {
        super(String.format("Only one of the both entities can be not null! Input='%s'", input));
        this.input = input;
    }
}
