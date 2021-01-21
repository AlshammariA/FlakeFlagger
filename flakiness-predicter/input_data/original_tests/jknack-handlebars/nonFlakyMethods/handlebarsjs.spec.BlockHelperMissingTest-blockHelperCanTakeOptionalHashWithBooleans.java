@Test public void blockHelperCanTakeOptionalHashWithBooleans() throws IOException {
  Hash helpers=$("goodbye",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      Boolean print=options.hash("print");
      if (print) {
        return "GOODBYE " + options.hash("cruel") + " "+ options.fn(context);
      }
 else {
        return "NOT PRINTING";
      }
    }
  }
);
  shouldCompileTo("{{#goodbye cruel=\"CRUEL\" print=true}}world{{/goodbye}}",$,helpers,"GOODBYE CRUEL world");
  shouldCompileTo("{{#goodbye cruel=\"CRUEL\" print=false}}world{{/goodbye}}",$,helpers,"NOT PRINTING");
}
