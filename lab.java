/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ideathor
 */
class lab {
   
    
  
    private int LabCode;
    private String LabName;
    private int numberOfpcs;

    
    public lab() {
    }

    public lab(int LabCode, String LabName, int numberOfpcs) {
        this.LabCode = LabCode;
        this.LabName = LabName;

        this.numberOfpcs = numberOfpcs;

    }

    public int getLabCode() {
        return LabCode;
    }

    public void setLabId(int LabCode) {
        this.LabCode = LabCode;
    }

    public String getLabName() {
        return LabName;
    }

    public void setLabName(String LabName) {
        this.LabName = LabName;
    }


    

    public int getnumberOfpcs() {
        return numberOfpcs;
    }

    public void setnumberOfpcs(int numberOfpcs) {
        this.numberOfpcs = numberOfpcs;
    }
}




    
   

