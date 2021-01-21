@Test public void should_group_bytes_in_integer() throws Exception {
  String literals=NumberGrouping.toBinaryLiteral("00000000000000000000000000000011");
  assertThat(literals).isEqualTo("00000000_00000000_00000000_00000011");
}
