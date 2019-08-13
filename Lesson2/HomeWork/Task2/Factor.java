
public class Factor implements Collectable{

    private final OutPutReport.Builder builder;
    private Outputable outputable;

    Factor() {
        builder = new OutPutReport.Builder();
    }

    @Override
    public Outputable make(Command command) {
        reset();
        switch (command){
            case DISPLAY:
                outputable = builder.addOutput(new DisplayReport()).build();
                break;
            case PRINT:
                outputable = builder.addOutput(new PrintReport()).build();
                break;
            case SAVE_FILE:
                outputable = builder.addOutput(new SaveFileReport()).build();
                break;
            case DISPLAY_PRINT:
                outputable = builder
                        .addOutput(new DisplayReport())
                        .addOutput(new PrintReport())
                        .build();
                break;
            case DISPLAY_SAVE_FILE:
                outputable = builder
                        .addOutput(new DisplayReport())
                        .addOutput(new SaveFileReport())
                        .build();
                break;
            case PRINT_SAVE_FILE:
                outputable = builder
                        .addOutput(new PrintReport())
                        .addOutput(new SaveFileReport())
                        .build();
                break;
            case ALL:
                outputable = builder
                        .addOutput(new DisplayReport())
                        .addOutput(new PrintReport())
                        .addOutput(new SaveFileReport())
                        .build();
                break;
            default:
                outputable = builder.build();
        }
        return outputable;
    }

    private void reset(){
        if (outputable == null) return;
        if (!outputable.getListOfOutput().isEmpty()) outputable.getListOfOutput().clear();
    }
}
