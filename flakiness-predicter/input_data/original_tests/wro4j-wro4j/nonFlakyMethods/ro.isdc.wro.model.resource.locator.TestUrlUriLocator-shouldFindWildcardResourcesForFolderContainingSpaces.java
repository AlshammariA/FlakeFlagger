@Test public void shouldFindWildcardResourcesForFolderContainingSpaces() throws IOException {
  victim.locate(createUri("/folder with spaces/**.css","test"));
}
