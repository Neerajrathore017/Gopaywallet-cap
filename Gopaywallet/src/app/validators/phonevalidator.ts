import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";
export function phoneValid():ValidatorFn
{
    return (control: AbstractControl): { [key: string]: any } | null =>
    {
        const regex = /^([+]\d{2})?\d{10}$/;
        if(regex.test(control.value)==false)
        return {"":false}
        else
        return null
    }
}
