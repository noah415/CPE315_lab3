class IFormat extends Instruction{
    private int rs;
    private int rt;
    private int immediate;

    public IFormat(int opcode, int rs, int rt, int immediate){
        super(opcode);
        this.rs = rs;
        this.rt = rt;
        this.immediate = immediate;
    }

    // TODO: insert logic for calculating the address of label (if needed)

    // TODO: insert logic for printing in binary
    public void printBinary()
    {
      String op = Instruction.bTS(opcode, 6);
      String srs = Instruction.bTS(rs, 5);
      String srt = Instruction.bTS(rt, 5);
      String simm = Instruction.bTS(immediate, 16);
      System.out.println(op + " " + srs + " " + srt + " " + simm);
    }

    public void execute()
    {
        switch(opcode)
        {
            case 8:
                addi();
                break;
            case 4:
                beq();
                break;
            case 5:
                bne();
                break;
            case 35:
                lw();
                break;
            case 43:
                sw();
                break;
        }
    }

    // may be wrong registers

    private void addi(){ lab3.registerList[rt] = lab3.registerList[rs] + immediate; }

    private void beq(){
        if (rs == rt)
            lab3.registerList[32] = lab3.registerList[32] + immediate + 1;
    }

    private void bne(){
        if (rs != rt)
            lab3.registerList[32] = lab3.registerList[32] + immediate + 1;
    }

    private void lw(){ lab3.registerList[rt] = lab3.registerList[rs] + immediate; }

    private void sw(){ lab3.memory[lab3.registerList[rt]] = lab3.registerList[rs] + immediate; }
}
