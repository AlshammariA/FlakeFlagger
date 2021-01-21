@Test public void whenUsingBlockFormArgumentsToHelpersCanBeRetrievedFromOptionsHashInStringForm() throws IOException {
  Hash helpers=$("wycats",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return "HELP ME MY BOSS " + options.param(0) + ' '+ options.param(1)+ ": "+ options.fn();
    }
  }
);
  assertEquals("HELP ME MY BOSS is.a slave.driver: help :(",compile("{{#wycats this is.a slave.driver}}help :({{/wycats}}",helpers,true).apply($));
}
