@Test public void block(){
  parse("{{#block 678}}{{var}}{{/block}}");
  parse("{{#block 678}}then{{^}}else{{/block}}");
  parse("{{#block 678}}then{{^}}else{{/block}}");
}
