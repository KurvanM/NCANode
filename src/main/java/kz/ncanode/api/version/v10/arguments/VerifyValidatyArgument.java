package kz.ncanode.api.version.v10.arguments;

import kz.ncanode.api.ApiServiceProvider;
import kz.ncanode.api.core.ApiArgument;
import kz.ncanode.api.core.ApiVersion;
import kz.ncanode.api.exceptions.InvalidArgumentException;

public class VerifyValidatyArgument extends ApiArgument  {
	
    ApiVersion ver;
    ApiServiceProvider man;
    private boolean required = false;
    private boolean checkValidity = false;

    public VerifyValidatyArgument(boolean required, ApiVersion ver, ApiServiceProvider man) {
        this.required = required;
        this.ver = ver;
        this.man = man;
    }

    @Override
    public void validate() throws InvalidArgumentException {
        try {
        	
        	if ((boolean)(params.get("checkValidity") == null)) {
        	//checkValidity = (boolean)(params.get("verifyCrl") == null ? false : params.get("verifyCrl"));
        		throw new InvalidArgumentException("Argument 'checkValidity' is required: true or false");
        	}
        	
        	checkValidity = (boolean)(params.get("checkValidity"));
        } catch (ClassCastException e) {
            //
        }
    }

    @Override
    public Object get() {
        return checkValidity;
    }

    @Override
    public String name() {
        return "checkValidity";
    }

}
