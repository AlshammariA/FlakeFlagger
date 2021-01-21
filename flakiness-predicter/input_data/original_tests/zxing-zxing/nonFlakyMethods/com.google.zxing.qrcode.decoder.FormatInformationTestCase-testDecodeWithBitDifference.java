@Test public void testDecodeWithBitDifference(){
  FormatInformation expected=FormatInformation.decodeFormatInformation(MASKED_TEST_FORMAT_INFO,MASKED_TEST_FORMAT_INFO);
  assertEquals(expected,FormatInformation.decodeFormatInformation(MASKED_TEST_FORMAT_INFO ^ 0x01,MASKED_TEST_FORMAT_INFO ^ 0x01));
  assertEquals(expected,FormatInformation.decodeFormatInformation(MASKED_TEST_FORMAT_INFO ^ 0x03,MASKED_TEST_FORMAT_INFO ^ 0x03));
  assertEquals(expected,FormatInformation.decodeFormatInformation(MASKED_TEST_FORMAT_INFO ^ 0x07,MASKED_TEST_FORMAT_INFO ^ 0x07));
  assertNull(FormatInformation.decodeFormatInformation(MASKED_TEST_FORMAT_INFO ^ 0x0F,MASKED_TEST_FORMAT_INFO ^ 0x0F));
}
