@Test public void shouldGenerateModelAsJson() throws Exception {
  victim.handle(mockRequest,mockResponse);
  assertEquals(readJsonFile("wroModel_simple.json"),outputStream.toString());
}
