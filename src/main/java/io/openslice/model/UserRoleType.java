/**
 * Copyright 2017 University of Patras 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License.
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and limitations under the License.
 */

package io.openslice.model;

/**
 * @author ctranoris
 * different defined user roles
 */

public enum UserRoleType {

	ROLE_ADMIN("ROLE_ADMIN"),
	ROLE_EXPERIMENTER("ROLE_EXPERIMENTER"),
	ROLE_VXF_DEVELOPER("ROLE_VXF_DEVELOPER"),
	ROLE_TESTBED_PROVIDER("ROLE_TESTBED_PROVIDER"),
	ROLE_MENTOR("ROLE_MENTOR");
	
	
	

    private String value;

	UserRoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static UserRoleType getEnum(String value) {
        for(UserRoleType v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
	
}
