import { ReactComponent as GitCatIcon } from "assets/img/gitcat.svg"
import "./styles.css"

function NavBar() {
    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>DS Movie</h1>

                    <a href="https://github.com/PaulaDev21" target="_blank" rel="noreferrer">
                        <div className="dsmovie-contact-content">
                            <GitCatIcon />
                            <p className="dsmovie-contact-link">/PaulaDev</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default NavBar
