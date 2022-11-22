package com.trackival.mdm.contact.exception;

import com.trackival.mdm.common.exception.TrackivalMasterDataException;
import com.trackival.mdm.contact.dto.AddContactInput;
import com.trackival.mdm.contact.dto.RemoveContactInput;
import lombok.Getter;

@Getter
public class CouldNotRemoveContactException extends TrackivalMasterDataException {
    private final RemoveContactInput input;

    public CouldNotRemoveContactException(RemoveContactInput input) {
        super(String.format("Only one of the both entities can be not null! Input='%s'", input));
        this.input = input;
    }
}
