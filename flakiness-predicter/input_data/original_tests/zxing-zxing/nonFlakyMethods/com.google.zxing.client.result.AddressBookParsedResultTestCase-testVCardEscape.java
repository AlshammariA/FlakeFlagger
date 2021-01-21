@Test public void testVCardEscape(){
  doTest("BEGIN:VCARD\r\nNOTE:foo\\nbar\r\nEND:VCARD",null,null,null,null,null,null,null,null,null,"foo\nbar");
  doTest("BEGIN:VCARD\r\nNOTE:foo\\;bar\r\nEND:VCARD",null,null,null,null,null,null,null,null,null,"foo;bar");
  doTest("BEGIN:VCARD\r\nNOTE:foo\\\\bar\r\nEND:VCARD",null,null,null,null,null,null,null,null,null,"foo\\bar");
  doTest("BEGIN:VCARD\r\nNOTE:foo\\,bar\r\nEND:VCARD",null,null,null,null,null,null,null,null,null,"foo,bar");
}
