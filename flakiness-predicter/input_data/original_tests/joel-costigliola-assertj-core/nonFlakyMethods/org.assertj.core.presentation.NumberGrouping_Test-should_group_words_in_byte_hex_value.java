@Test public void should_group_words_in_byte_hex_value() throws Exception {
  String hexLiteral=NumberGrouping.toHexLiteral("CA");
  assertThat(hexLiteral).isEqualTo("CA");
}
