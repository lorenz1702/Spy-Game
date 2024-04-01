package applikation
import domain.*
class DisplayRoleUseCaseImpl (
    private val gameRepository: GameRepository
) : DisplayRoleUseCase{
    override fun displayRole(user: User) {
        user.displayRole()
    }
}