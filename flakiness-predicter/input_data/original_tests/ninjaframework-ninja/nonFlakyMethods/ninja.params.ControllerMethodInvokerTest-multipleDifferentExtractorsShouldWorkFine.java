@Test public void multipleDifferentExtractorsShouldWorkFine(){
  when(context.getParameter("param1")).thenReturn("value");
  when(context.getPathParameter("param2")).thenReturn("20");
  create("multiple").invoke(mockController,context);
  verify(mockController).multiple("value",20,context,session);
}
