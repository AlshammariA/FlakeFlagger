@Test public void newlines() throws IOException {
  shouldCompileTo("Alan's\nTest","{}","Alan's\nTest");
  shouldCompileTo("Alan's\rTest","{}","Alan's\rTest");
}
