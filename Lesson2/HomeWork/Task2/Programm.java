class Programm{
	public static void main(String[] args){
		Report report = new Report();
		report.calculate();
		Factor factor = new Factor();
		report.output(factor.make(Command.DISPLAY));
		System.out.println("-----------");
		report.output(factor.make(Command.PRINT_SAVE_FILE));
	}
}