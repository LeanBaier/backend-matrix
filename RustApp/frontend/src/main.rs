use yew::prelude::*;

mod components;

struct App;

fn main() {
    yew::start_app::<App>();
}

impl Component for App {
    type Message = ();
    type Properties = ();

    fn create(_ctx: &Context<Self>) -> Self {
        Self
    }

    fn view(&self, _ctx: &Context<Self>) -> Html {
        html! {
            <>
              <section class={classes!("section", "is-max-desktop", "has-background-dark")}>
                <div class={classes!("container", "box", "has-background-light")}>
                    <components::titulos::TituloPrincipal titulo = {"Pagina de prueba"} />
                </div>
                <div class={classes!("container", "box", "has-batckground-success")}>
                    <components::cards::CatCard titulo={"Cat Cards"} cantidad = {10} />
                </div>
            </section>
            <footer class={classes!("footer", "is-max-desktop", "has-background-link")}>
                <div class = {classes!("container", "box")}>
                    <h1 class = {classes!("title", "has-text-centered")}>{"Footer"}</h1>
                </div>
            </footer>

            </>
        }
    }
}