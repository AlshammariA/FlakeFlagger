@Test public void invertedSectionsWithUnsetValue() throws IOException {
  String string="{{#goodbyes}}{{this}}{{/goodbyes}}{{^goodbyes}}Right On!{{/goodbyes}}";
  Object hash=$;
  shouldCompileTo(string,hash,"Right On!","Inverted section rendered when value isn't set.");
}
