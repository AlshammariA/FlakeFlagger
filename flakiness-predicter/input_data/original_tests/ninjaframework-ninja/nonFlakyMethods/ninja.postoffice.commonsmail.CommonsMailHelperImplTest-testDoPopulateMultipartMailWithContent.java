/** 
 * Note: - Setting of header parameters not (yet) tested as we cannot get back the headers set easily.
 * @throws Exception
 */
@Test public void testDoPopulateMultipartMailWithContent() throws Exception {
  Mail mail=MailImplTestHelper.getMailImplWithDemoContent();
  MultiPartEmail multiPartEmail=commonsmailHelper.createMultiPartEmailWithContent(mail);
  commonsmailHelper.doPopulateMultipartMailWithContent(multiPartEmail,mail);
  assertTrue(doConvertAdressesToInternetAddressList(multiPartEmail.getBccAddresses()).contains(new InternetAddress("bcc1@domain")));
  assertTrue(doConvertAdressesToInternetAddressList(multiPartEmail.getBccAddresses()).contains(new InternetAddress("bcc2@domain")));
  assertEquals("subject",multiPartEmail.getSubject());
  assertEquals(new InternetAddress("from1@domain"),multiPartEmail.getFromAddress());
  assertTrue(doConvertAdressesToInternetAddressList(multiPartEmail.getReplyToAddresses()).contains(new InternetAddress("replyTo1@domain")));
  assertTrue(doConvertAdressesToInternetAddressList(multiPartEmail.getReplyToAddresses()).contains(new InternetAddress("replyTo2@domain")));
  assertTrue(doConvertAdressesToInternetAddressList(multiPartEmail.getCcAddresses()).contains(new InternetAddress("cc1@domain")));
  assertTrue(doConvertAdressesToInternetAddressList(multiPartEmail.getCcAddresses()).contains(new InternetAddress("cc1@domain")));
  assertTrue(doConvertAdressesToInternetAddressList(multiPartEmail.getBccAddresses()).contains(new InternetAddress("bcc1@domain")));
  assertTrue(doConvertAdressesToInternetAddressList(multiPartEmail.getBccAddresses()).contains(new InternetAddress("bcc2@domain")));
  assertTrue(doConvertAdressesToInternetAddressList(multiPartEmail.getToAddresses()).contains(new InternetAddress("to1@domain")));
  assertTrue(doConvertAdressesToInternetAddressList(multiPartEmail.getToAddresses()).contains(new InternetAddress("to2@domain")));
}
