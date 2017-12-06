package es.svqjug.java101.permission;

import org.junit.Test;

// import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Jorge Jiménez Barra <jjimenez@intellimentsec.com>
 */
public class PermissionMatcherTest {

    PermissionMatcher permissionMatcher = new PermissionMatcher();

    @Test
    public void whenTwoPermissionAreEqualsThenReturnTrue() {

        boolean match = permissionMatcher.match("user:list", "user:list");

        assertThat(match).isEqualTo(true);
    }

    @Test
    public void whenTwoPermissionNotAreEqualsDepthThenReturnFalse() {

        boolean match = permissionMatcher.match("user:get:4", "user:get");
        boolean simetricMatch = permissionMatcher.match("user:get", "user:get:4");

        assertThat(match).isEqualTo(false);
        assertThat(match).isEqualTo(simetricMatch);
    }

    @Test
    public void whenTwoPermissionAreDiferentThenReturnFalse() {

        boolean match = permissionMatcher.match("user:get", "scenario:list");

        assertThat(match).isEqualTo(false);
    }

    @Test
    public void whenTwoPermissionHaveDiferentEndScopeThenReturnFalse() {

        boolean match = permissionMatcher.match("user:get:4", "user:get:5");

        assertThat(match).isEqualTo(false);
    }

    @Test
    public void whenTwoPermissionHaveFirstScopeDiferentThenReturnFalse() {

        boolean match = permissionMatcher.match("user:get:4", "scenario:get:4");

        assertThat(match).isEqualTo(false);
    }

    @Test
    public void whenFoundAsteriskInScopeThenAnyElementMatchAfterThisScope() {

        boolean match = permissionMatcher.match("user:delete:1", "user:*");

        assertThat(match).isEqualTo(true);
    }

    @Test
    public void whenFoundAsteriskInEndScopeThenEmptyElementNoMatch() {
        boolean match = permissionMatcher.match("user:delete", "user:delete:*");

        assertThat(match).isEqualTo(false);
    }

    @Test
    public void whenFoundAsteriskInNoEndScopeThenMatchAnyElementAfterThisScope() {

        boolean match = permissionMatcher.match("scenario:*:delete", "scenario:20:create");

        assertThat(match).isEqualTo(true);
    }

    @Test
    public void whenFoundAsteriskInStartedScopeThenAnyElementMatch() {

        boolean match = permissionMatcher.match("*:delete", "user:create");

        assertThat(match).isEqualTo(true);
    }

    @Test
    public void whenFoundQuestionMarkAndAllOtherScopeMatchThenPermissionNoMatch() {

        boolean match = permissionMatcher.match("user:?:delete", "user:4:delete");

        assertThat(match).isEqualTo(true);
    }

    @Test
    public void whenFoundQuestionMarkButNexScopeNoMatchThenPermissionNoMatch() {

        boolean match = permissionMatcher.match("user:?:delete", "user:4:create");

        assertThat(match).isEqualTo(false);
    }

    @Test
    public void whenFoundQuestionMarkButPreviousScopeNoMatchThenPermissionNoMatch() {

        boolean match = permissionMatcher.match("scenario:?:delete", "user:4:delete");

        assertThat(match).isEqualTo(false);
    }

    @Test
    public void whenFoundQuestionMarkInEndScopeAndHaveSameDepthThenPermissionNoMatch() {

        boolean match = permissionMatcher.match("user:?", "user:4");

        assertThat(match).isEqualTo(true);
    }

    @Test
    public void whenFoundQuestionMarkInEndScopeAndHaveMoreScopeThenNoMatch() {

        boolean match = permissionMatcher.match("user:?", "user:4:deploy");

        assertThat(match).isEqualTo(false);
    }
}
