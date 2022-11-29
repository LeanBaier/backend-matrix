use yew::prelude::*;

pub struct CatCard;

#[derive(Debug, Default, Properties, PartialEq)]
pub struct CatCardProps {
    pub titulo: String,
    pub cantidad: u32,
}

struct CatData {
    nombre: String,
    edad: String,
    descripcion: String,
    imagen: String,
}

impl Component for CatCard {
    type Message = ();
    type Properties = CatCardProps;

    fn create(ctx: &Context<Self>) -> Self {
        Self
    }

    fn view(&self, ctx: &Context<Self>) -> Html {
        let data = vec!(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);

        let data = data.iter().map(|v| {
            CatData {
                nombre: format!("Nombre {v}"),
                edad: format!("{v}"),
                descripcion: format!("Descripcion del gato nro {v}"),
                imagen: "https://cataas.com/cat".to_string(),
            }
        });
        html! {
            <>
            <div class = {classes!("container", "columns")}>
            <div class = {classes!("column")}>
                <p class={classes!("title")}>{ctx.props().titulo.clone()}</p>
            </div>
            </div>
            <div class={classes!("columns", "is-mobile", "is-multiline", "is-variable")}>
            {
                data.into_iter().map(|v| {
                html!{
                    <div class = {classes!("column", "is-one-third-desktop", "is-one-third-tablet", "is-one-third-widescreen", "is-one-third-fullhd", "is-full-mobile")}>
                    <div class={classes!("card")}>
                        <div class = {classes!("card-image")}>
                            <figure class={classes!("image", "is-4by3")}>
                                <img src={v.imagen.clone()} alt={"Placeholder image"}/>
                            </figure>
                        </div>
                        <div class = {classes!("card-content")}>
                            <div class = {classes!("media")}>
                                <div class = {classes!("media-left")}>
                                    <figure class={classes!("image", "is-48x48")}>
                                        <img src={v.imagen.clone()} alt={"Placeholder image"}/>
                                    </figure>
                                </div>
                                <div class = {classes!("media-content")}>
                                    <p class={classes!("title", "is-4")}>{v.nombre.clone()}</p>
                                    <p class={classes!("subtitle", "is-6")}>{"Edad: "}{v.edad.clone()}</p>
                                </div>
                            </div>

                            <div class = {classes!("content")}>
                                {v.descripcion.clone()}
                            </div>
                        </div>
                    </div>
                    </div>
                }
            }).collect::<Html>()
            }
            </div>
            </>
        }
    }
}