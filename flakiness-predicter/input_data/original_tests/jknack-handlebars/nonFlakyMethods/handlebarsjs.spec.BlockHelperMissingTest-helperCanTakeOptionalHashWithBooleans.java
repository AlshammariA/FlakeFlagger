@Test public void helperCanTakeOptionalHashWithBooleans() throws IOException {
  Hash helpers=$("goodbye",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      Boolean print=options.hash("print");
      if (print) {
        return "GOODBYE " + options.hash("cruel") + " "+ options.hash("world");
      }
 else {
        return "NOT PRINTING";
      }
    }
  }
);
  shouldCompileTo("{{goodbye cruel=\"CRUEL\" world=\"WORLD\" print=true}}",$,helpers,"GOODBYE CRUEL WORLD");
  shouldCompileTo("{{goodbye cruel=\"CRUEL\" world=\"WORLD\" print=false}}",$,helpers,"NOT PRINTING");
}
