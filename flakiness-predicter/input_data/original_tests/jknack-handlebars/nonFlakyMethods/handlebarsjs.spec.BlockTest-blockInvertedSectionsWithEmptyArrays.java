@Test public void blockInvertedSectionsWithEmptyArrays() throws IOException {
  shouldCompileTo("{{#people}}{{name}}{{^}}{{none}}{{/people}}",$("none","No people","people",new Object[0]),"No people");
}
