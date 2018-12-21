package projectmanager


class GlobalConfigService {

    MemberService memberService
    ManagerService managerService
    OwnerService ownerService

    public static boolean isBuilding = false;
    public static boolean isGeneratingSchema = false;

    def itemsPerPage() {
        return 10
    }

    public static String getUID(){
        return UUID.randomUUID().toString().toUpperCase();
    }

}
