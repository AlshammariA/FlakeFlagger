@Test public void should_group_words_in_hex_value() throws Exception {
  String hexLiteral=NumberGrouping.toHexLiteral("01234567");
  assertThat(hexLiteral).isEqualTo("0123_4567");
}
