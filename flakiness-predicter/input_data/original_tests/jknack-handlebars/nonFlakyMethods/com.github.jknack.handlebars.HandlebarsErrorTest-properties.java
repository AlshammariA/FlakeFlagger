@Test public void properties(){
  HandlebarsError hbsError=new HandlebarsError("filename",1,3,"reason","evidence","message");
  assertEquals("filename",hbsError.filename);
  assertEquals(1,hbsError.line);
  assertEquals(3,hbsError.column);
  assertEquals("reason",hbsError.reason);
  assertEquals("evidence",hbsError.evidence);
  assertEquals("message",hbsError.message);
}
