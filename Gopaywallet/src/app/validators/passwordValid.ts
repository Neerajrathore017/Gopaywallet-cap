import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";
export function passwordValid():ValidatorFn
{
    return (control: AbstractControl): { [key: string]: any } | null =>
    {
        const regex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\w\s]).{7,}$/;
        if(regex.test(control.value)==false)
        return {"":false}
        else
        return null
    }
}
