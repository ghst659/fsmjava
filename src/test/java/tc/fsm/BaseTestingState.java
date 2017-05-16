package tc.fsm;

/* package-private */ abstract class BaseTestingState {
    /**
     * For this application, the way to translate a class to a registration name.
     * @param cls  The State class for which we need a registration tag.
     * @return The string registration tag.
     */
    protected static String tag(Class cls) {
        String fullName = cls.getName();
        int dot = fullName.lastIndexOf('.');
        return fullName.substring(dot + 1);
    }

    /**
     * The registration name for the class.
     * @return  The string registration name.
     */
    public String name() {
        return tag(this.getClass());
    }
}
