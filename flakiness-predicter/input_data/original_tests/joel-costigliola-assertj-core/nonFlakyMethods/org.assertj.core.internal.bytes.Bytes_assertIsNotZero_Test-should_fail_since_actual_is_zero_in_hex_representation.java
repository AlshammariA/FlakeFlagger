@Test public void should_fail_since_actual_is_zero_in_hex_representation(){
  thrown.expectAssertionError("\nExpecting:\n <0x00>\nnot to be equal to:\n <0x00>\n");
  bytes.assertIsNotZero(someHexInfo(),(byte)0x00);
}
