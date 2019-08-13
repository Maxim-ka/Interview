import java.util.*;
class Report{
	private List<ReportItem> items;	// Отчетные данные

	// расчет отчетных данных
	public void calculate(){
		items =  new ArrayList<>();
		items.add(new ReportItem("First", (float)5));
		items.add(new ReportItem("Second", (float)6));
	}
	
	public void output(Outputable outputable){
		List<Derivable> derivableList = outputable.getListOfOutput();
		if (derivableList.isEmpty()) return;
		for (Derivable derivable: derivableList){
			derivable.output(items);
		}
	}
}