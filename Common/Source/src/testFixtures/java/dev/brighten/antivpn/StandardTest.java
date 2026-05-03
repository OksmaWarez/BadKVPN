package dev.brighten.antivpn;

import com.github.benmanes.caffeine.cache.Cache;
import dev.brighten.antivpn.api.APIPlayer;
import dev.brighten.antivpn.api.CheckResult;
import dev.brighten.antivpn.api.ResultType;
import dev.brighten.antivpn.web.objects.VPNResponse;

public class StandardTest {

    protected void mockCache() throws NoSuchFieldException, IllegalAccessException {
        mockCache("1.1.1.1", new CheckResult(VPNResponse.builder().success(true).proxy(true).ip("1.1.1.1")
                .method("N/A").countryName("N/A").countryCode("N/A").city("N/A").build(), ResultType.DENIED_PROXY, true));
    }

    protected void mockCache(String ip, CheckResult result) throws NoSuchFieldException, IllegalAccessException {
        var field = APIPlayer.class.getDeclaredField("checkResultCache");
        field.setAccessible(true);
        Cache<String, CheckResult> checkResultCache = (Cache<String, CheckResult>) field.get(null);

        checkResultCache.put(ip, result);
    }
}
