@Test(expected=WroRuntimeException.class) public void cannotBuildCSVWheInvalidOptionsFormatProvided(){
  optionsBuilder.buildFromCsv("var:unused");
}
