@Test public void testDecodeWithMisread(){
  FormatInformation expected=FormatInformation.decodeFormatInformation(MASKED_TEST_FORMAT_INFO,MASKED_TEST_FORMAT_INFO);
  assertEquals(expected,FormatInformation.decodeFormatInformation(MASKED_TEST_FORMAT_INFO ^ 0x03,MASKED_TEST_FORMAT_INFO ^ 0x0F));
}
