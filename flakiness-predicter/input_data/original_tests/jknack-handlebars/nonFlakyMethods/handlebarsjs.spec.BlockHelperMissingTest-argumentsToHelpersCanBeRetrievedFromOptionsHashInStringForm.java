@Test public void argumentsToHelpersCanBeRetrievedFromOptionsHashInStringForm() throws IOException {
  Hash helpers=$("wycats",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return "HELP ME MY BOSS " + options.param(0) + ' '+ options.param(1);
    }
  }
);
  assertEquals("HELP ME MY BOSS is.a slave.driver",compile("{{wycats this is.a slave.driver}}",helpers,true).apply($));
}
