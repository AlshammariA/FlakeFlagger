@Test public void blockHelperCanTakeOptionalHash() throws IOException {
  Hash helpers=$("goodbye",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return "GOODBYE " + options.hash("cruel") + " "+ options.fn(context)+ " "+ options.hash("times")+ " TIMES";
    }
  }
);
  shouldCompileTo("{{#goodbye cruel=\"CRUEL\" times=12}}world{{/goodbye}}",$,helpers,"GOODBYE CRUEL world 12 TIMES");
}
