@Test public void whenInsideABlockInStringModePassesTheAppropriateContextInTheOptionsHash() throws IOException {
  Hash helpers=$("tomdale",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return "STOP ME FROM READING HACKER NEWS I " + context + " "+ options.param(0);
    }
  }
,"with",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return options.fn(context);
    }
  }
);
  assertEquals("STOP ME FROM READING HACKER NEWS I need-a dad.joke",compile("{{#with dale}}{{tomdale ../need dad.joke}}{{/with}}",helpers,true).apply($("dale",$,"need","need-a")));
}
