import java.util.List;

public class SaveFileReport implements Derivable {

    @Override
    public void output(List<ReportItem> items) {
        System.out.println("Output to file");
        for(ReportItem item : items){
            System.out.format("file %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }
}
