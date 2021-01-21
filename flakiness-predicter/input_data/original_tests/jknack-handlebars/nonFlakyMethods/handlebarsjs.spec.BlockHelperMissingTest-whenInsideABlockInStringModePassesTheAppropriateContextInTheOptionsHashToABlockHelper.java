@Test public void whenInsideABlockInStringModePassesTheAppropriateContextInTheOptionsHashToABlockHelper() throws IOException {
  Hash helpers=$("tomdale",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return "STOP ME FROM READING HACKER NEWS I " + context + " "+ options.param(0)+ " "+ options.fn(context);
    }
  }
,"with",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return options.fn(context);
    }
  }
);
  assertEquals("STOP ME FROM READING HACKER NEWS I need-a dad.joke wot",compile("{{#with dale}}{{#tomdale ../need dad.joke}}wot{{/tomdale}}{{/with}}",helpers,true).apply($("dale",$,"need","need-a")));
}
