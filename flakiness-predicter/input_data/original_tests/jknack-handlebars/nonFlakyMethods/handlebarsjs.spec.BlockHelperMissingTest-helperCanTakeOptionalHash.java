@Test public void helperCanTakeOptionalHash() throws IOException {
  Hash helpers=$("goodbye",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return "GOODBYE " + options.hash("cruel") + " "+ options.hash("world")+ " "+ options.hash("times")+ " TIMES";
    }
  }
);
  shouldCompileTo("{{goodbye cruel=\"CRUEL\" world=\"WORLD\" times=12}}",$,helpers,"GOODBYE CRUEL WORLD 12 TIMES");
}
