@Test public void testCharacterCount(){
  assertEquals(10,Mode.NUMERIC.getCharacterCountBits(Version.getVersionForNumber(5)));
  assertEquals(12,Mode.NUMERIC.getCharacterCountBits(Version.getVersionForNumber(26)));
  assertEquals(14,Mode.NUMERIC.getCharacterCountBits(Version.getVersionForNumber(40)));
  assertEquals(9,Mode.ALPHANUMERIC.getCharacterCountBits(Version.getVersionForNumber(6)));
  assertEquals(8,Mode.BYTE.getCharacterCountBits(Version.getVersionForNumber(7)));
  assertEquals(8,Mode.KANJI.getCharacterCountBits(Version.getVersionForNumber(8)));
}
