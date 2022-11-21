update User user set
    user.firstName=if((:firstName is null), user.firstName, :firstName),
    user.lastName=if((:lastName is null), user.lastName, :lastName),
    user.mail=if((:mail is null), user.mail, :mail),
    user.password=if((:password is null), user.password, :password),
    user.dateOfBirth=if((:dateOfBirth is null), user.dateOfBirth, :dateOfBirth),
    user.biography=if((:biography is null), user.biography, :biography),
    user.address=if((:address is null), user.address, :address),
    user.gender=if((:gender is null), user.gender, :gender)
where user.id=:id
