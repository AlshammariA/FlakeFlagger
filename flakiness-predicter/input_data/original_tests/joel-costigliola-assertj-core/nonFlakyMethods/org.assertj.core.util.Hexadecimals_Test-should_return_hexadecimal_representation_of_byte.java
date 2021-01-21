@Test public void should_return_hexadecimal_representation_of_byte() throws Exception {
  assertThat(Hexadecimals.byteToHexString((byte)0x00)).isEqualTo("00");
  assertThat(Hexadecimals.byteToHexString((byte)0xFF)).isEqualTo("FF");
  assertThat(Hexadecimals.byteToHexString((byte)0xa2)).isEqualTo("A2");
}
