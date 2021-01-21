@Test public void invertedSectionsWithFalseValue() throws IOException {
  String string="{{#goodbyes}}{{this}}{{/goodbyes}}{{^goodbyes}}Right On!{{/goodbyes}}";
  Object hash="{goodbyes: false}";
  shouldCompileTo(string,hash,"Right On!","Inverted section rendered when value is false.");
}
