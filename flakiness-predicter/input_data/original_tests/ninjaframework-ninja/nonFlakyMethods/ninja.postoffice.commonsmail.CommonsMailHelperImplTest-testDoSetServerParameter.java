@Test public void testDoSetServerParameter() throws Exception {
  Mail mail=MailImplTestHelper.getMailImplWithDemoContent();
  MultiPartEmail multiPartEmail=commonsmailHelper.createMultiPartEmailWithContent(mail);
  commonsmailHelper.doSetServerParameter(multiPartEmail,"mail.superserver.com",33,true,"username","password",true);
  assertEquals("33",multiPartEmail.getSmtpPort());
  assertEquals("mail.superserver.com",multiPartEmail.getHostName());
  assertEquals(true,multiPartEmail.getMailSession().getDebug());
}
