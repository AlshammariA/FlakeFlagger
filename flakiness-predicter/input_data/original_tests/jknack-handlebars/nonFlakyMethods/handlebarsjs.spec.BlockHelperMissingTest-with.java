@Test public void with() throws IOException {
  String string="{{#with person}}{{first}} {{last}}{{/with}}";
  shouldCompileTo(string,"{person: {first: Alan, last: Johnson}}","Alan Johnson");
}
