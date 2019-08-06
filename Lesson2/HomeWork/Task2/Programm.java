class Programm{
	public static void main(String[] args){
		Report report = new Report();
		report.calculate();
		report.output(new OutPutReport.Builder()
						.addPrint(new PrintReport())
						.addDisplay(new DisplayReport())
						.addFile(new SaveFileReport())
						.build());
	}
}